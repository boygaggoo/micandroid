package ningbo.media.service;

import ningbo.media.bean.UserModuleFiles;
import ningbo.media.core.service.BaseService;

public interface UserModuleFilesService extends BaseService<UserModuleFiles, Integer>{

	public UserModuleFiles getUserModuleFilesByUserId(Integer fileId,String md5Value) ;
}
