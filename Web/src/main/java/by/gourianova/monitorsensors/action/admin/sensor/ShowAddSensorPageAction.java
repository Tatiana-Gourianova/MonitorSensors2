package by.gourianova.monitorsensors.action.admin.sensor;

import by.gourianova.monitorsensors.SensorType;
import by.gourianova.monitorsensors.SensorUnit;
import by.gourianova.monitorsensors.action.Action;
import by.gourianova.monitorsensors.controller.Router;
import by.gourianova.monitorsensors.exception.ServiceException;
import by.gourianova.monitorsensors.service.SensorTypeService;
import by.gourianova.monitorsensors.service.SensorUnitService;
import by.gourianova.monitorsensors.util.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class ShowAddSensorPageAction implements Action {
    private final static String TYPES_LIST = "sensorTypesList";
    private final static String UNITS_LIST = "sensorUnitsList";
    private final static String SENSOR_ID = "sensorId";

    private final static String MESSAGE = "message";
    private SensorTypeService sensorTypeService = new SensorTypeService();
    private SensorUnitService sensorUnitService = new SensorUnitService();

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Router router = new Router();

        ArrayList<SensorType> typesList;
        ArrayList<SensorUnit> unitsList;
        try {
            typesList = sensorTypeService.findAll();
            unitsList = sensorUnitService.findAll();
            request.setAttribute(TYPES_LIST, typesList);
            request.setAttribute(UNITS_LIST, unitsList);
            router.setPagePath(PageConstant.ADD_SENSOR);
        } catch (ServiceException e) {
            request.getSession().setAttribute(MESSAGE, e.getMessage());
            router.setPagePath(PageConstant.ERROR_PAGE);
            router.setRoute(Router.RouteType.REDIRECT);
        }
        return router;
    }
}
