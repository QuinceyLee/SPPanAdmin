package net.sppan.base.service.system.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import net.sppan.base.common.utils.MD5Utils;
import net.sppan.base.dao.IRoleDao;
import net.sppan.base.dao.IUserDao;
import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Role;
import net.sppan.base.entity.User;
import net.sppan.base.service.system.IUserService;
import net.sppan.base.service.support.impl.BaseServiceImpl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * <p>
 * 用户账户表  服务实现类
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IRoleDao iRoleDao;
	
	@Override
	public IBaseDao<User, Integer> getBaseDao() {
		return userDao;
	}

	@Override
	public User findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public void saveOrUpdate(User user) {
		if(user.getId() != null){
			User dbUser = find(user.getId());
			dbUser.setNickName(user.getNickName());
			dbUser.setSex(user.getSex());
			dbUser.setBirthday(user.getBirthday());
			dbUser.setTelephone(user.getTelephone());
			dbUser.setEmail(user.getEmail());
			dbUser.setAddress(user.getAddress());
			dbUser.setLocked(user.getLocked());
			dbUser.setDescription(user.getDescription());
			dbUser.setUpdateTime(new Date());
			update(dbUser);
		}else{
			user.setCreateTime(new Date());
			user.setUpdateTime(new Date());
			user.setDeleteStatus(0);
			user.setPassword(MD5Utils.md5("admin"));
			save(user);
		}
	}
	
	

	@Override
	@Transactional
	public void delete(Integer id) {
		User user = find(id);
		Assert.state(!"admin".equals(user.getUserName()),"超级管理员用户不能删除");
		super.delete(id);
		userDao.DeleteRelationship(id);
	}

	@Override
	public void grant(Integer id, String[] roleIds) {
		User user = find(id);
		Assert.notNull(user, "用户不存在");
		Assert.state(!"admin".equals(user.getUserName()),"超级管理员用户不能修改管理角色");
		Role role;
		Set<Role> roles = new HashSet<>();
		if(roleIds != null){
			for (int i = 0; i < roleIds.length; i++) {
				Integer rid = Integer.parseInt(roleIds[i]);
				role = iRoleDao.findById(rid).get();
				roles.add(role);
			}
		}
		user.setRoles(roles);
		update(user);
	}

	@Override
	public Page<User> findAllByLike(String searchText, PageRequest pageRequest) {
		pageRequest.getSort();
		if(StringUtils.isBlank(searchText)){
				return userDao.findAll(pageRequest);
		}
		return userDao.findAllByNickNameContaining(searchText,pageRequest);
	}

	
	@Override
	public void updatePwd(User user, String oldPassword, String password1, String password2) {
		Assert.notNull(user, "用户不能为空");
		Assert.notNull(oldPassword, "原始密码不能为空");
		Assert.notNull(password1, "新密码不能为空");
		Assert.notNull(password2, "重复密码不能为空");
		
		User dbUser = userDao.findByUserName(user.getUserName());
		Assert.notNull(dbUser, "用户不存在");
		
		Assert.isTrue(user.getPassword().equals(MD5Utils.md5(oldPassword)), "原始密码不正确");;
		Assert.isTrue(password1.equals(password2), "两次密码不一致");
		dbUser.setPassword(MD5Utils.md5(password1));
		userDao.saveAndFlush(dbUser);
	}
	
}
