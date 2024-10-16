package lk.ijse.dao;

import lk.ijse.entity.impl.CustomerEntity;
import lk.ijse.entity.impl.ItemCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCartDao extends JpaRepository<ItemCart, String> {
}
