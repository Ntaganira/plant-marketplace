package rw.ntaganira.orders.utils;

import rw.ntaganira.orders.entity.Order;
import rw.ntaganira.orders.entity.OrderItem;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * --------------------------------------------------------------------
 * Project      : Rwanda Plant Marketplace
 * File         : WhatsAppMessageBuilder.java
 * Author       : Heritier Ntaganira
 * Company      : NIHO TECHNOLOGIES LTD
 * Created Date : 2026-05-14
 * Description  : Generates WhatsApp checkout messages
 * --------------------------------------------------------------------
 */

public class WhatsAppMessageBuilder {

    private WhatsAppMessageBuilder() {
    }

    public static String buildMessage(
            Order order,
            List<OrderItem> items
    ) {

        NumberFormat format =
                NumberFormat.getCurrencyInstance(
                        Locale.US
                );

        StringBuilder message =
                new StringBuilder();

        message.append("Hello ")
                .append(order.getVendor()
                        .getBusinessName())
                .append("%0A%0A");

        message.append("I would like to order:%0A%0A");

        for (OrderItem item : items) {

            message.append(item.getProduct().getName())
                    .append("%0A");

            message.append("Qty: ")
                    .append(item.getQuantity())
                    .append("%0A");

            message.append("Price: ")
                    .append(
                            format.format(
                                    item.getTotalPrice()
                            )
                    )
                    .append("%0A");

            message.append("Image: ")
                    .append(
                            item.getProduct()
                                    .getThumbnailUrl()
                    )
                    .append("%0A%0A");
        }

        message.append("Total Amount: ")
                .append(
                        format.format(
                                order.getTotalAmount()
                        )
                )
                .append("%0A%0A");

        message.append("Customer Information%0A");

        message.append("Phone: ")
                .append(order.getCustomerPhoneNumber())
                .append("%0A");

        message.append("Address: ")
                .append(order.getDeliveryAddress());

        return message.toString();
    }

}