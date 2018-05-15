package io.swagger.server.api.verticle;

import io.swagger.server.api.model.Carpets;

public class DefaultApiImpl implements DefaultApi {

	@Override
	public Carpets carpetsGet() {
		// TODO Auto-generated method stub
		Carpets my =new Carpets();
		my.setCategory("all real");
		my.setId(5);
		my.setName("the real carpet");
		
		return my;
	}

	@Override
	public Carpets carpetsPost(Carpets body) {
		// TODO Auto-generated method stub
		return null;
	}

}
