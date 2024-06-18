package app.project.content.agreement.domain.repository;

import app.project.content.agreement.domain.entity.Agreement;

public interface CreateAgreementRepository {

    Long save(Agreement agreement);
}
