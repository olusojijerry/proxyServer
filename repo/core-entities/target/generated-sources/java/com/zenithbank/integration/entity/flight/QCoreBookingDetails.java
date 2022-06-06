package com.zenithbank.integration.entity.flight;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCoreBookingDetails is a Querydsl query type for CoreBookingDetails
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCoreBookingDetails extends EntityPathBase<CoreBookingDetails> {

    private static final long serialVersionUID = 1736090432L;

    public static final QCoreBookingDetails coreBookingDetails = new QCoreBookingDetails("coreBookingDetails");

    public final StringPath accountNo = createString("accountNo");

    public final StringPath address = createString("address");

    public final StringPath bookingData = createString("bookingData");

    public final StringPath bookingId = createString("bookingId");

    public final StringPath bookingReference = createString("bookingReference");

    public final StringPath city = createString("city");

    public final StringPath country = createString("country");

    public final StringPath countryCode = createString("countryCode");

    public final DateTimePath<java.util.Date> createdDt = createDateTime("createdDt", java.util.Date.class);

    public final StringPath dateOfBirth = createString("dateOfBirth");

    public final StringPath email = createString("email");

    public final StringPath expiryDate = createString("expiryDate");

    public final StringPath firstName = createString("firstName");

    public final StringPath gender = createString("gender");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastName = createString("lastName");

    public final StringPath middleName = createString("middleName");

    public final NumberPath<Long> partnerId = createNumber("partnerId", Long.class);

    public final StringPath partnerName = createString("partnerName");

    public final StringPath passengerType = createString("passengerType");

    public final StringPath passportIssuingAuthority = createString("passportIssuingAuthority");

    public final StringPath passportNumber = createString("passportNumber");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath postalCode = createString("postalCode");

    public final StringPath postingReference = createString("postingReference");

    public final StringPath productType = createString("productType");

    public final StringPath status = createString("status");

    public final StringPath targetCurrency = createString("targetCurrency");

    public final StringPath title = createString("title");

    public QCoreBookingDetails(String variable) {
        super(CoreBookingDetails.class, forVariable(variable));
    }

    public QCoreBookingDetails(Path<? extends CoreBookingDetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCoreBookingDetails(PathMetadata metadata) {
        super(CoreBookingDetails.class, metadata);
    }

}

