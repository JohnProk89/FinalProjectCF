package gr.aueb.cf.gg1.specifications;

import gr.aueb.cf.gg1.model.Gamer;
import gr.aueb.cf.gg1.model.User;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

public class GamerSpecification {

    public GamerSpecification() {

    }

    public static Specification<Gamer> gamerUserGamingId(String gamingId) {
        return ((root, query, criteriaBuilder) -> {
            if (gamingId == null || gamingId.isBlank()) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }

            Join<Gamer, User> user = root.join("user");
            return criteriaBuilder.equal(user.get("gamingId"), gamingId);
        });
    }

    public static Specification<Gamer> grUserIsActive(Boolean isActive) {
        return ((root, query, criteriaBuilder) -> {
            if (isActive == null) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }

            Join<Gamer, User> user = root.join("user");
            return criteriaBuilder.equal(user.get("isActive"), isActive);
        });
    }

    public static Specification<Gamer> grStringFieldLike(String field, String value) {
        return ((root, query, criteriaBuilder) -> {
            if (value == null || value.trim().isEmpty()) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
            return criteriaBuilder.like(criteriaBuilder.upper(root.get(field)), "%" + value.toUpperCase() + "%"); // case insensitive
        });
    }
}
