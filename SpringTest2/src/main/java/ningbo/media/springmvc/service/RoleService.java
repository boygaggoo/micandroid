package ningbo.media.springmvc.service;

import java.util.List;

import ningbo.media.springmvc.domain.Role;

public interface RoleService {

	public boolean insertRole(Role role);

	public Role getRole(int roleId);

	public List<Role> getRoles();

	public boolean updateRole(Role role);

	public boolean deleteRole(Role roleId);

}