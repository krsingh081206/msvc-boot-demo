package com.example.mongo.order.demo.invoice;

import com.example.mongo.order.demo.address.Address;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InvoiceRepository extends
 PagingAndSortingRepository<Invoice, String> {

 Invoice findByBillingAddress(Address address);
}
