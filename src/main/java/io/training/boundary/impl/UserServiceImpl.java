package io.training.boundary.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import io.training.boundary.UserService;
import io.training.entity.User;
import io.training.util.Constants;

import java.util.List;
import java.util.Optional;

@Stateless
public class UserServiceImpl extends AbstractBeanImpl<User, Long> implements UserService {
  @PersistenceContext(name = Constants.ENTITY_MANAGER_NAME)
  private EntityManager entityManager;
  public UserServiceImpl() {
    super(User.class);
  }

  @Override
  protected EntityManager getEntityManager() {
    return entityManager;
  }

  @Override
  public Optional<User> getUserByEmail(String email) {
    TypedQuery<User> userTypedQuery = getEntityManager()
            .createQuery("Select u from User u where u.email=:email",User.class).
            setParameter("email",email);
    List<User> resultList = userTypedQuery.getResultList();
    if(resultList.size()>0){
      return Optional.of(resultList.get(0));
    }
    return Optional.empty();
  }

  @Override
  public Optional<User> getUserByUsername(String username) {
    TypedQuery<User> userTypedQuery = getEntityManager()
            .createQuery("select u from User u where u.username=:username",User.class).
                    setParameter("username",username);
    List<User> resultList = userTypedQuery.getResultList();
    if(resultList.size()>0){
      return Optional.of(resultList.get(0));
    }
    return Optional.empty();
  }
}
