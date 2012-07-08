package com.cloudshaped.generated;

import java.util.List;


import com.fancythinking.reg.hibernate_example.dal.DAO;

public class ChannelDAO extends DAO<Channel> {

	public Channel findByPrimaryKey(Long id) {
		return super.findByPrimaryKey(Channel.class, id);
	}
	
	public List<Channel> findAll() {
		return super.findAll(new Channel());
	}

}
