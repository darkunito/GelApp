package edu.upc.eetac.dsa.dsaqp1415g3.gelapp.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.ServerErrorException;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import edu.upc.eetac.dsa.dsaqp1415g3.gelapp.api.model.Sabor;
import edu.upc.eetac.dsa.dsaqp1415g3.gelapp.api.MediaType;
import edu.upc.eetac.dsa.dsaqp1415g3.gelapp.api.DataSourceSPA;

@Path("/sabor")
public class SaborResource {
	private DataSource ds = DataSourceSPA.getInstance().getDataSource();
	
	private String GET_SABOR_BY_ID_QUERY ="select * from sabor where sabor_id =?";
	@GET
	@Path("/{sabor_id}")
	@Produces(MediaType.GELAPP_API_SABOR)
	
	public Sabor getSabor(@PathParam("sabor_id") String saborid,
			@Context Request request) {
		Sabor sabor = new Sabor();

		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServerErrorException("Could not connect to the database",
					Response.Status.SERVICE_UNAVAILABLE);
		}

		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(GET_SABOR_BY_ID_QUERY);
			stmt.setInt(1, Integer.valueOf(saborid));
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				sabor.setSaborid(rs.getInt("sabor_id"));
				sabor.setName(rs.getString("nombre"));
				sabor.setCode_color(rs.getString("codigo_color"));
			} else {
				throw new NotFoundException("There's no sting with stingid="
						+ saborid);
			}
		} catch (SQLException e) {
			throw new ServerErrorException(e.getMessage(),
					Response.Status.INTERNAL_SERVER_ERROR);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				conn.close();
			} catch (SQLException e) {
			}
		}

		return sabor;
	}
	
	/*private Sabor getSaborFromDatabase(String saborid) {
		Sabor sabor = new Sabor();

		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			throw new ServerErrorException("Could not connect to the database",
					Response.Status.SERVICE_UNAVAILABLE);
		}

		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(GET_SABOR_BY_ID_QUERY);
			stmt.setInt(1, Integer.valueOf(saborid));
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				sabor.setSaborid(rs.getInt("saborid"));
				sabor.setName(rs.getString("nombre"));
				sabor.setCode_color(rs.getString("codigo_color"));
			} else {
				throw new NotFoundException("There's no sting with stingid="
						+ saborid);
			}
		} catch (SQLException e) {
			throw new ServerErrorException(e.getMessage(),
					Response.Status.INTERNAL_SERVER_ERROR);
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				conn.close();
			} catch (SQLException e) {
			}
		}

		return sabor;
	}*/
}
