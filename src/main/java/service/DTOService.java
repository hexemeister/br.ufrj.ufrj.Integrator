package service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import dao.DoadorDAO;
import dto.DoadorDTO;

@Path("/lista")
public class DTOService {

	@GET
	@Produces({MediaType.APPLICATION_JSON + ";charset=utf-8", MediaType.TEXT_PLAIN + ";charset=utf-8"})
	public List<DoadorDTO> listaDoador() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		List<DoadorDTO> lista = new DoadorDAO().getDoadorList();
		return lista;
	}
	
}
