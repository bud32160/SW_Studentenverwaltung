package entities;

import enumerations.ERoom;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Exam.class)
public abstract class Exam_ {

	public static volatile SingularAttribute<Exam, Date> date;
	public static volatile SingularAttribute<Exam, String> instructor;
	public static volatile SingularAttribute<Exam, String> ID;
	public static volatile SingularAttribute<Exam, String> time;
	public static volatile SingularAttribute<Exam, String> courseId;
	public static volatile SingularAttribute<Exam, ERoom> room;
	public static volatile SingularAttribute<Exam, Integer> capacity;

}

