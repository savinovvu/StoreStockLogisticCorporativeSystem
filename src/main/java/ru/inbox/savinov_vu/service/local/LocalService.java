package ru.inbox.savinov_vu.service.local;

import ru.inbox.savinov_vu.model.local.LocalStorage;

import java.util.List;

public interface LocalService {

    void deleteLocal(int id);
    void addLocal(LocalStorage local);
    List<LocalStorage> getAllLocal();
    void updateLocal(LocalStorage local);

}
