package entities;

import enumerations.ERole;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Administrator.class)
public abstract class Administrator_ {

	public static volatile SingularAttribute<Administrator, ERole> role;
	public static volatile SingularAttribute<Administrator, Integer> ID;
	public static volatile SingularAttribute<Administrator, String> userId;

}

