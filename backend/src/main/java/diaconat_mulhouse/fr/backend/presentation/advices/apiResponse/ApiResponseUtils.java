package diaconat_mulhouse.fr.backend.presentation.advices.apiResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Class that completes an HttpServletResponse with a ApiError
 *
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse
 */
public class ApiResponseUtils {

    /**
     * Private static final attribute that converts an ApiError in a Json
     */
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Public static method that completes an api response with an api error
     *
     * @param httpServletResponse The api response
     * @param apiError The api error
     * @throws IOException For errors in the HTTP stream
     */
    public static void jsonError(HttpServletResponse httpServletResponse, ApiError apiError) throws IOException {
        httpServletResponse.setStatus(apiError.getStatusCode());
        httpServletResponse.setContentType("application/json");
        mapper.writeValue(httpServletResponse.getOutputStream(), apiError);
    }
}
