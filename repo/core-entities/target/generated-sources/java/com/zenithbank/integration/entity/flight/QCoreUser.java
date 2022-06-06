package com.zenithbank.integration.entity.flight;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCoreUser is a Querydsl query type for CoreUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCoreUser extends EntityPathBase<CoreUser> {

    private static final long serialVersionUID = -1039354846L;

    public static final QCoreUser coreUser = new QCoreUser("coreUser");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.util.Date> createdDt = createDateTime("createdDt", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath password = createString("password");

    public final StringPath userName = createString("userName");

    public QCoreUser(String variable) {
        super(CoreUser.class, forVariable(variable));
    }

    public QCoreUser(Path<? extends CoreUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCoreUser(PathMetadata metadata) {
        super(CoreUser.class, metadata);
    }

}

