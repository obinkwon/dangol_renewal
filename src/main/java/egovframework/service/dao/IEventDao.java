package egovframework.service.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.model.Event;
import egovframework.model.Store;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("IEventDao")
public class IEventDao extends EgovAbstractMapper {
	
	private final Logger logger = LoggerFactory.getLogger(ICategoryDao.class);
	
	@Resource(name = "egov.sqlSession")
	public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
		super.setSqlSessionFactory(sqlSession);
	}
	
	public List<Event> selectEventList(Event event);
	public List<Event> selectAllEvents();
	public List<Event> selectIngEvents();
	public List<Event> selectEdEvents();
	public List<Event> selectAllEventsBySnums(HashMap<String, int[]> hm);
	public List<Event> selectIngEventsBySnums(HashMap<String, int[]> hm);
	public List<Event> selectEdEventsBySnums(HashMap<String, int[]> hm);
	public Event selectOneEvent(int eid);
	
	public List<Store> selectStoresByBid(Store store);
	public Store selectStoreBySnum(int snum);
	public List<Store> selectStoresBySnums(HashMap<String, int[]> hm);
	
	public int insertEvent(Event event);
	public int deleteEvent(int eid);
	public int updateEvent(Event event);
}
