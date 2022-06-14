package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RastreioListagem;

public class RastreioDaoJDBC implements ListagemDao {

	private Connection conn;

	public RastreioDaoJDBC(Connection conn) {
		super();
		this.conn = conn;
	}

	private RastreioListagem instantiateCadastro(ResultSet rs) throws SQLException {
		return new RastreioListagem(rs.getInt("id"),rs.getString("origem"),rs.getString("destino"), rs.getString("status"), rs.getString("datahora_entrada"), rs.getString("datahora_saida"), rs.getInt("rota"), rs.getString("localizacao"));
	}

	@Override
	public List<RastreioListagem> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT r.id, r.status, u.municipio as origem, u2.municipio as destino, status, datahora_entrada, datahora_saida, rota, u3.municipio as localizacao\n" +
					"from rastreio r\n" +
					"inner join unidades u on u.codigo = r.origem\n" +
					"inner join unidades u2 on u2.codigo = r.destino\n" +
					"inner join unidades u3 on u3.codigo = r.localizacao;");
			rs = st.executeQuery();
			List<RastreioListagem> list = new ArrayList<>();
			while (rs.next()) {
				RastreioListagem cad = instantiateCadastro(rs);
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

	@Override
	public RastreioListagem findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT r.id, r.status, u.municipio as origem, u2.municipio as destino, status, datahora_entrada, datahora_saida, rota, u3.municipio as localizacao\n" +
					"from rastreio r\n" +
					"inner join unidades u on u.codigo = r.origem\n" +
					"inner join unidades u2 on u2.codigo = r.destino\n" +
					"inner join unidades u3 on u3.codigo = r.localizacao where id = ?;");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				RastreioListagem cad = instantiateCadastro(rs);
				return cad;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}

	}

}
