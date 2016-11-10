package ru.inbox.savinov_vu.service.local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.local.LocalStorage;
import ru.inbox.savinov_vu.repository.LocalRepository;

import java.util.List;

@Service
public class LocalServiceImpl implements LocalService {

    @Autowired
    LocalRepository repository;

    @Override
    public void deleteLocal(LocalStorage local) {
        repository.delete(local.getLocalId());
    }

    @Override
    public void addLocal(LocalStorage local) {
        repository.saveAndFlush(local);
    }

    @Override
    public List<LocalStorage> getAllLocal() {
        return repository.findAll();
    }

    @Override
    public void updateLocal(LocalStorage local) {
        repository.saveAndFlush(local);
    }
}
