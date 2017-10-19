import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.hibernate.transform.Transformers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import dto.DoadorDTO;

public class Principal {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mssql");
		
		EntityManager em = emf.createEntityManager();
		
		Session session = em.unwrap(Session.class);
		
//		List<Object[]> nomes = em.createNativeQuery("select top 10 doador from hemo.dbo.atendim").getResultList();
//		List<Object> nomes = em.createNativeQuery("select top 10 nomedoador from hemo.dbo.atendim order by nomedoador").getResultList();
//		List<Object[]> nomes = em.createNativeQuery("select top 10 nomedoador, localizacao from hemo.dbo.atendim where dtatend between convert(varchar, '01/01/2017',103) and convert(varchar, '31/01/2017',103)").getResultList();
		
//		for (Object[] o : nomes) {
//			System.out.println("Nome: " + o[0] + "        Localização: " + o[1]);
//		}
		
//		List<DoadorDTO> nomes = session.createNativeQuery("select top 10 nomedoador as nome, localizacao from hemo.dbo.atendim where dtatend between convert(varchar, '01/01/2017',103) and convert(varchar, '31/01/2017',103)").setResultTransformer(Transformers.aliasToBean(DoadorDTO.class)).list();
		List<Tuple> nomes = session.createNativeQuery("select top 10 nomedoador as nome, localizacao from hemo.dbo.atendim where dtatend between convert(varchar, '01/01/2017',103) and convert(varchar, '31/01/2017',103)").setResultTransformer(Transformers.aliasToBean(DoadorDTO.class)).list();
		
		
//		Query q = session.createNativeQuery("select top 10 nomedoador as nome, localizacao from hemo.dbo.atendim where dtatend between convert(varchar, '01/01/2017',103) and convert(varchar, '31/01/2017',103)").setResultTransformer(Transformers.aliasToBean(DoadorDTO.class));
//		q.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
//		
//		List<Map<String, Tuple>> nomes = q.list();
		
		System.out.println("+++ " + nomes);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			System.out.println(mapper.writeValueAsString(nomes));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		nomes.forEach((n)->System.out.println("Nome: " + n.getNome() + "        Localização: " + n.getLocalizacao().toString()));
//		for (DoadorDTO doadorDTO : nomes) {
//			System.out.println(doadorDTO);
//		}
		em.close();
		emf.close();
	}

}
