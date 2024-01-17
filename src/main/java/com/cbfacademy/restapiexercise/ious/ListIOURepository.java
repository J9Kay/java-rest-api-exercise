package com.cbfacademy.restapiexercise.ious;

import com.cbfacademy.restapiexercise.core.PersistenceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ListIOURepository implements IOURepository {
    private final List<IOU> ious = new ArrayList<>();

    @Override
    public List<IOU> retrieveAll() {
        return new ArrayList<>(ious);
    }

    @Override
    public IOU retrieve(UUID id) {
        return ious.stream().filter(iou -> iou.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public IOU create(IOU entity) {
        ious.add(entity);
        return entity;
    }

    @Override
    public void delete(UUID id) {
        ious.removeIf(iou -> iou.getId().equals(id));
    }

    @Override
    public IOU update(IOU entity) {
        int index = ious.indexOf(entity);
        if (index != -1) {
            ious.set(index, entity);
            return entity;
        }
        throw new PersistenceException("IOU not found for update");
    }

    @Override
    public List<IOU> searchByBorrower(String name) {
        return ious.stream().filter(iou -> iou.getBorrower().equals(name)).collect(Collectors.toList());
    }

    @Override
    public List<IOU> searchByLender(String name) {
        return ious.stream().filter(iou -> iou.getLender().equals(name)).collect(Collectors.toList());
    }
}
