package ningbo.media.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import ningbo.media.bean.Location;
import ningbo.media.core.page.Pagination;
import ningbo.media.core.service.impl.BaseServiceImpl;
import ningbo.media.dao.LocationDao;
import ningbo.media.data.entity.LocationDetail;
import ningbo.media.service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("locationService")
public class LocationServiceImpl extends BaseServiceImpl<Location, Integer>
		implements LocationService {

	@Resource
	private LocationDao locationDao;

	@Autowired
	public LocationServiceImpl(@Qualifier("locationDao")
	LocationDao locationDao) {
		super(locationDao);
	}

	public List<Location> queryLocationByName(String locationName) {
		return locationDao.queryLocationByName(locationName);
	}

	public Long getLocationCount() {
		return super.getTotalCount();
	}

	public List<Location> queryLocationByPage(int pageNo, int pageSize) {
		Pagination<Location> page = locationDao.queryLocationByPage(pageNo,
				pageSize);
		System.out.println(page.getPageNo());
		System.out.println(page.getTotalPage());
		System.out.println(page.getTotalCount());
		return page.getList();
	}

	public Location queryLocationByMd5(String md5Value) {
		String hql = "from Location as model where 1=1 and model.md5Value = ? ";
		Location location = (Location) locationDao.findUnique(hql, md5Value);

		if (null != location) {
			return location;
		}
		return null;
	}

	public List<LocationDetail> queryLoctionsByLat(Double latitude, Double longitude) {
		double area = 0.0005;
		double frontLat = latitude + area;
		double backLat = latitude - area;
		double frontlon = longitude + area;
		double backlon = longitude - area;

		String hql = "from Location as model where 1=1 and model.latitude > ? and model.latitude < ? and model.longitude > ? and model.longitude < ? ";

		List<Location> lists = locationDao.findByHql(hql, backLat, frontLat,backlon, frontlon);
		List<LocationDetail> datas = new ArrayList<LocationDetail>();
		if (null != lists && lists.size() > 0) {
			for(Location loc : lists){
				LocationDetail detail = new LocationDetail();
				detail.setMd5Value(loc.getMd5Value()) ;
				detail.setName_cn(loc.getName_cn()) ;
				detail.setName_en(loc.getName_en()) ;
				detail.setAddress_cn(loc.getAddress_cn()) ;
				detail.setAddress_en(loc.getAddress_en()) ;
				detail.setLatitude(loc.getLatitude()) ;
				detail.setLongitude(loc.getLongitude()) ;
				detail.setName_py(loc.getName_py()) ;
				
				datas.add(detail) ;
			}
			return datas;
		}
		return null;
	}

}