package lk.ijse.dao;

import lk.ijse.entity.impl.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<ItemEntity, String> {
}
