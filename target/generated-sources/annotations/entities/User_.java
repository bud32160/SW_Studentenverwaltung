package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, Integer> roleUserId;
	public static volatile SingularAttribute<User, String> mailAddress;
	public static volatile SingularAttribute<User, Integer> ID;
	public static volatile SingularAttribute<User, String> userName;

}

