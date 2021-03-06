package by.gourianova.monitorsensors.service;


import by.gourianova.monitorsensors.Sensor;
import by.gourianova.monitorsensors.User;
import by.gourianova.monitorsensors.dao.SensorDao;
import by.gourianova.monitorsensors.exception.DaoException;
import by.gourianova.monitorsensors.exception.ServiceException;
import by.gourianova.monitorsensors.util.ValidateSensor;
import by.gourianova.monitorsensors.util.ValidateUser;

import java.util.ArrayList;


public class SensorService {

    private SensorDao sensorDao = new SensorDao();

    public ArrayList<Sensor> findAll() throws ServiceException {
        ArrayList<Sensor> sensorsList;
        try {
            sensorsList = sensorDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in findAll method", e);
        }
        return sensorsList;
    }

    public ArrayList<Sensor> findAllByPage(int pageCapacity, int pageNumber) throws ServiceException {
        ArrayList<Sensor> sensorsList;
        try {
            sensorsList = sensorDao.findAllByPage(pageCapacity, pageNumber);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in findAllByPage method", e);
        }
        return sensorsList;
    }

    public ArrayList<Sensor>  findEntityByTitleAndModel(String name, String model) throws ServiceException {
        ArrayList<Sensor> sensorsList;
        try {
            sensorsList = sensorDao. findEntityByTitleAndModel(name, model);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in findEntityByTitleAndModel method", e);
        }
        return sensorsList;

    }

    public Sensor editEntity(Integer entityId) throws ServiceException {
        Sensor sensor;
        sensor = sensorDao.editEntity(entityId);

        return sensor;
    }

    public Sensor findSensorById(Integer id) throws ServiceException {
        try {
            return sensorDao.findEntityById(id);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in findUserById method", e);
        }
    }

    public boolean createSensor(Sensor sensor) throws ServiceException {
        try {
            return sensorDao.createEntity(sensor);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in createApp method", e);
        }
    }

    public boolean deleteEntityById(Integer id) throws ServiceException {
        try {
            return sensorDao.deleteEntityById(id);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in delete method", e);
        }

    }
    public String validateSensor(Sensor Sensor) throws ServiceException {

        return ValidateSensor.validate(Sensor);
    }

    public void updateSensor(Sensor sensor) throws ServiceException {
        try {
            sensorDao.updateEntity(sensor);
        } catch (DaoException e) {
            throw new ServiceException("Transaction failed in updateUser method", e);
        }
    }
}
