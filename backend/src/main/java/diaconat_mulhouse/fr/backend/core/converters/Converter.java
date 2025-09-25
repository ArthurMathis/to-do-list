package diaconat_mulhouse.fr.backend.core.converters;

/**
 * Interface that convert DTO to Model and reverse
 *
 * @param <DTO>
 * @param <Model>
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public interface Converter<DTO, Model> {

    /**
     * Public method that converts a DTO to a Model
     *
     * @param dto The DTO
     * @return The new Model
     */
    public Model fromDto(DTO dto);

    /**
     * Public method that converts a Model to a DTO
     *
     * @param model The Model
     * @return The new DTO
     */
    public DTO toDto(Model model);

}
