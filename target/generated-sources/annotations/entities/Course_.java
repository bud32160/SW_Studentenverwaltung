package entities;

import enumerations.ERoom;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Course.class)
public abstract class Course_ {

	public static volatile SingularAttribute<Course, Date> date;
	public static volatile SingularAttribute<Course, String> majorId;
	public static volatile SingularAttribute<Course, String> instructor;
	public static volatile SingularAttribute<Course, String> description;
	public static volatile SingularAttribute<Course, Integer> ID;
	public static volatile SingularAttribute<Course, String> time;
	public static volatile SingularAttribute<Course, ERoom> room;
	public static volatile SingularAttribute<Course, Integer> capacity;

}

