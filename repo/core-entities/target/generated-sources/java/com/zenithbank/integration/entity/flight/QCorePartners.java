package com.zenithbank.integration.entity.flight;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCorePartners is a Querydsl query type for CorePartners
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCorePartners extends EntityPathBase<CorePartners> {

    private static final long serialVersionUID = 492470658L;

    public static final QCorePartners corePartners = new QCorePartners("corePartners");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.util.Date> createdDt = createDateTime("createdDt", java.util.Date.class);

    public final StringPath creditAcctNo = createString("creditAcctNo");

    public final StringPath creditAccttype = createString("creditAccttype");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath partnerName = createString("partnerName");

    public final StringPath status = createString("status");

    public QCorePartners(String variable) {
        super(CorePartners.class, forVariable(variable));
    }

    public QCorePartners(Path<? extends CorePartners> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCorePartners(PathMetadata metadata) {
        super(CorePartners.class, metadata);
    }

}

