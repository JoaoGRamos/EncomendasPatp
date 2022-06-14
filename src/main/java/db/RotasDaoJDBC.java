package db;

import model.RotasListagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RotasDaoJDBC implements ListagemRotasDao{
    private Connection conn;

    public RotasDaoJDBC(Connection conn) {
        super();
        this.conn = conn;
    }

    private RotasListagem instantiateCadastro(ResultSet rs) throws SQLException {
        return new RotasListagem(rs.getInt("id"),rs.getString("unidade_origem"),rs.getString("unidade_destino"));
    }

    @Override
    public List<RotasListagem> listaAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("select id ,u.municipio as unidade_origem, u2.municipio as unidade_destino\n" +
                    "from rotas r \n" +
                    "inner join unidades u on u.codigo = r.unidade_origem \n" +
                    "inner join unidades u2 on u2.codigo = r.unidade_destino\n" +
                    "order by id;");
            rs = st.executeQuery();
            List<RotasListagem> list = new ArrayList<>();
            while (rs.next()) {
                RotasListagem cad = instantiateCadastro(rs);
                list.add(cad);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }
    }
}
