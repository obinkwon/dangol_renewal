package egovframework.dangol.dao;

import java.util.HashMap;
import java.util.List;

import egovframework.dangol.model.Event;
import egovframework.dangol.model.Store;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("IEventDao")
public interface IEventDao {
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
