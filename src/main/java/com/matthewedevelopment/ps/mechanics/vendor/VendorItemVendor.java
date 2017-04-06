package com.matthewedevelopment.ps.mechanics.vendor;

import com.matthewedevelopment.ps.mechanics.item.generator.ItemGenerator;

/**
 * Created by Matthew E on 4/5/2017.
 */
public class VendorItemVendor extends Vendor{
    public VendorItemVendor() {
        super("Item Vendor", 18);
        addVendorItem(ItemGenerator.createOrb(1), 2000);
    }
}
