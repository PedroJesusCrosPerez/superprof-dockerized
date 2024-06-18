package app.project.content.agreement.domain.repository;

import app.project.content.agreement.domain.entity.Agreement;

public interface UpdateAgreementRepository {

    Agreement update(Agreement agreement);
}
