package com.microsoft.gbb.rasa.makelineservice.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.Query;
import com.microsoft.gbb.rasa.makelineservice.dto.OrderSummaryDto;
import com.microsoft.gbb.rasa.makelineservice.model.OrderSummary;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface OrderSummaryRepository extends CosmosRepository<OrderSummaryDto, String> {
    // Query all orders
    @Query(value = "SELECT * FROM c")
    List<OrderSummaryDto> getAllOrders();

    // Query for equality using ==
    @Query(value = "SELECT * FROM c WHERE c.id = @storeId")
    ArrayList<OrderSummaryDto> getOrdersForStore(@Param("storeId") String storeId);

    ArrayList<OrderSummary> findAllByStoreId(String storeId);
}
