package com.heima;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;

public class SolrTest {
	@Test
	public void solrSearch() throws InterruptedException{
		Object object2 = new Object();
		object2.wait();
		
		HttpSolrServer hss = new HttpSolrServer("http://localhost:8080/solr/");
		SolrQuery sq = new SolrQuery();
		sq.setQuery("product_name:花");
		QueryResponse query = null;
		try {
			query = hss.query(sq);
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SolrDocumentList results = query.getResults();
		
		System.out.println("总共有"+results.getNumFound());
		for (SolrDocument sd : results) {
			String object = (String)sd.get("product_name");
			System.out.println(object);
		}
	}
}
