package com.jefflife.gameserver.item.adapter.out.persistence;

import com.jefflife.gameserver.item.adapter.out.persistence.entity.FloorItemBrokerEntity;
import com.jefflife.gameserver.item.adapter.out.persistence.entity.ItemEntity;
import com.jefflife.gameserver.item.application.domain.model.Item;
import com.jefflife.gameserver.item.application.port.out.LoadItemPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class LoadItemAdapter implements LoadItemPort {
    private final ItemRepository itemRepository;
    private final FloorRepository floorRepository;

    public LoadItemAdapter(ItemRepository itemRepository, FloorRepository floorRepository) {
        this.itemRepository = itemRepository;
        this.floorRepository = floorRepository;
    }

    @Override
    public List<Item> findByName(String name) {
        return itemRepository.findByNameLike(name)
                .stream()
                .map(ItemEntity::toDomain)
                .toList();
    }

    @Override
    public List<Item> findByFloorId(long floorId) {
        return floorRepository.findById(floorId)
                .map(floor -> floor.getItems()
                        .stream()
                        .map(FloorItemBrokerEntity::getItem)
                        .map(ItemEntity::toDomain)
                        .toList())
                .orElseThrow(() -> new NoSuchElementException("Floor not found with ID: " + floorId));
    }
}
