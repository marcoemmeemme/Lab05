package it.polito.tdp.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AnagrammaDAO 
{
	public boolean isCorrect(String anagramma)
	{
		final String query="SELECT nome	FROM parola WHERE nome=?";
		boolean result;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				result=true;
			}
			else
			{
				result=false;
			}
			conn.close();
			return result;
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
