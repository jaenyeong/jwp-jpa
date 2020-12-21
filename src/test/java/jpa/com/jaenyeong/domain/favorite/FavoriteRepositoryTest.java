package jpa.com.jaenyeong.domain.favorite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayName("Favorite Repository 테스트")
class FavoriteRepositoryTest {
    @Autowired
    private FavoriteRepository favorites;

    private Favorite favorite;

    @BeforeEach
    void setUp() {
        favorite = new Favorite();
    }

    @Test
    @DisplayName("객체 저장 테스트")
    void save() {
        final Favorite save = favorites.save(favorite);

        assertThat(save.getId()).isNotNull();
        assertThat(save.getCreatedDate()).isNotNull();
        assertThat(save.getModifiedDate()).isNotNull();
    }

    @Test
    @DisplayName("객체 조회 테스트")
    void findById() {
        final Favorite save = favorites.save(favorite);

        assertThat(favorites.findById(save.getId())).isNotNull();
    }

    @Test
    void delete() {
        final Favorite save = favorites.save(favorite);
        final Long targetId = save.getId();

        assertThat(favorites.findById(targetId)).isNotNull();

        favorites.deleteById(targetId);
        final Favorite afterDelete = favorites.findById(targetId).orElse(null);

        assertThat(afterDelete).isNull();
    }
}
