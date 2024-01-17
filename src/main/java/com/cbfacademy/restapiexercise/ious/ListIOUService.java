package com.cbfacademy.restapiexercise.ious;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cbfacademy.restapiexercise.core.IOUNotFoundException;

import java.util.List;
import java.util.UUID;

@Service
public class ListIOUService implements IOUService {

    private final IOURepository iouRepository;

    @Autowired
    public ListIOUService(IOURepository iouRepository) {
        this.iouRepository = iouRepository;
    }

    @Override
    public List<IOU> getAllIOUs() {
        return iouRepository.retrieveAll();
    }

    @Override
    public IOU getIOU(UUID id) {
        IOU iou = iouRepository.retrieve(id);
        if (iou == null) {
            throw new IOUNotFoundException("IOU not found with ID: " + id);
        }
        return iou;
    }

    @Override
    public IOU createIOU(IOU iou) {
        return iouRepository.create(iou);
    }

    @Override
    public IOU updateIOU(UUID id, IOU updatedIOU) {
        getIOU(id); // This will throw the IOUNotFoundException if IOU is not found
        return iouRepository.update(updatedIOU);
    }

    @Override
    public void deleteIOU(UUID id) {
        getIOU(id); // This will throw the IOUNotFoundException if IOU is not found
        iouRepository.delete(id);
    }
}
