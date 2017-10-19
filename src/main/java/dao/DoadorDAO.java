package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import dto.DoadorDTO;
import persistence.PersistenceUtil;

public class DoadorDAO {

	Session session = new PersistenceUtil().getSession();
	
	public List<DoadorDTO> getDoadorList() {
		
		List<DoadorDTO> nomes = session.createNativeQuery("select top 10 nomedoador as nome, localizacao from hemo.dbo.atendim where dtatend between convert(varchar, '01/01/2017',103) and convert(varchar, '31/01/2017',103)").setResultTransformer(Transformers.aliasToBean(DoadorDTO.class)).list();
		return nomes;
	}
	
}
