package lk.ijse.posBackEnd.service;


import lk.ijse.posBackEnd.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemDTO dto);

    String updateItem(ItemDTO dto);

    ItemDTO searchItem(String id);

    String deleteItem(String id);

    List<ItemDTO> getAllItems();
}
