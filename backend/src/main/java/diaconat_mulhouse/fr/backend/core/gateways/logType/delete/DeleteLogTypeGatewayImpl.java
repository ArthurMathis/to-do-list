package diaconat_mulhouse.fr.backend.core.gateways.logType.delete;

import diaconat_mulhouse.fr.backend.domain.repositories.LogTypeRepository;

public class DeleteLogTypeGatewayImpl implements DeleteLogTypeGateway {

    private final LogTypeRepository logTypeRepository;

    public DeleteLogTypeGatewayImpl(LogTypeRepository logTypeRepository) {
        this.logTypeRepository = logTypeRepository;
    }

    @Override
    public void delete(Long id) {
        this.logTypeRepository.deleteById(id);
    }
}
