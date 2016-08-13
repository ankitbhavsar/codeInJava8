package fastcode.filter;

import fastcode.model.SmartPhone;
import fastcode.model.SmartPhoneType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilteringSmartPhones {

    public static void main(String[] args) {

//        Adding some SmartPhones to inventory
        List<SmartPhone> inventory = Arrays.asList(new SmartPhone(SmartPhoneType.Android, 4, true, "Marshmallow"),
                new SmartPhone(SmartPhoneType.Android, 5, true, "Marshmallow"),
                new SmartPhone(SmartPhoneType.iPhone, 4, true, "4S"),
                new SmartPhone(SmartPhoneType.iPhone, 5, true, "5"),
                new SmartPhone(SmartPhoneType.Blackberry, 5, false, "Z10"),
                new SmartPhone(SmartPhoneType.Blackberry, 6, false, "Z30")
        );

//        filterAndroidSmartPhones(inventory) = [SmartPhone{type=Android, screensize=4, waterproof=true, osversion='Marshmallow'}, SmartPhone{type=Android, screensize=5, waterproof=true, osversion='Marshmallow'}]
        System.out.println("filterAndroidSmartPhones(inventory) = " + filterAndroidSmartPhones(inventory));
//        filterWaterproofSmartPhones(inventory) = [SmartPhone{type=Android, screensize=4, waterproof=true, osversion='Marshmallow'}, SmartPhone{type=Android, screensize=5, waterproof=true, osversion='Marshmallow'}, SmartPhone{type=iPhone, screensize=4, waterproof=true, osversion='4S'}, SmartPhone{type=iPhone, screensize=5, waterproof=true, osversion='5'}]
        System.out.println("filterWaterproofSmartPhones(inventory) = " + filterWaterproofSmartPhones(inventory));
//      filterSmartPhones(inventory,SmartPhone::isWaterproof) = [SmartPhone{type=Android, screensize=4, waterproof=true, osversion='Marshmallow'}, SmartPhone{type=Android, screensize=5, waterproof=true, osversion='Marshmallow'}, SmartPhone{type=iPhone, screensize=4, waterproof=true, osversion='4S'}, SmartPhone{type=iPhone, screensize=5, waterproof=true, osversion='5'}]
        System.out.println("filterSmartPhones(inventory,SmartPhone::isWaterproof) = " + filterSmartPhones(inventory, SmartPhone::isWaterproof));
//      [SmartPhone{type=Android, screensize=4, waterproof=true, osversion='Marshmallow'}, SmartPhone{type=Android, screensize=5, waterproof=true, osversion='Marshmallow'}]
        System.out.println(filterSmartPhones(inventory, (SmartPhone sp) -> sp.getType().equals(SmartPhoneType.Android)));
//      [SmartPhone{type=Android, screensize=5, waterproof=true, osversion='Marshmallow'}, SmartPhone{type=iPhone, screensize=5, waterproof=true, osversion='5'}, SmartPhone{type=Blackberry, screensize=5, waterproof=false, osversion='Z10'}, SmartPhone{type=Blackberry, screensize=6, waterproof=false, osversion='Z30'}]
        System.out.println(filterSmartPhones(inventory, (SmartPhone sp) -> sp.getScreensize() > 4));
    }

//  Filtering SmartPhones traditional way..
    private static List<SmartPhone> filterAndroidSmartPhones(List<SmartPhone> inventory) {
        List<SmartPhone> result = new ArrayList<>();
        for (SmartPhone phone : inventory) {
            if (phone.getType().equals(SmartPhoneType.Android)) {
                result.add(phone);
            }
        }
        return result;
    }
//  Filtering Waterproof SmartPhones traditional way..
    private static List<SmartPhone> filterWaterproofSmartPhones(List<SmartPhone> inventory) {
        List<SmartPhone> result = new ArrayList<>();
        for (SmartPhone phone : inventory) {
            if (phone.isWaterproof()) {
                result.add(phone);
            }
        }
        return result;
    }


//  Filter SmartPhones using Predicate
    private static List<SmartPhone> filterSmartPhones(List<SmartPhone> inventory, Predicate<SmartPhone> pridicate) {
        List<SmartPhone> result = new ArrayList<>();
        for (SmartPhone smartPhone : inventory) {
            if (pridicate.test(smartPhone)) {
                result.add(smartPhone);
            }
        }
        return result;
    }

//    Filter SmartPhones using Stream.collect
    public static List<SmartPhone> filterSmartPhonesWithCollect(List<SmartPhone> inventory, Predicate<SmartPhone> smartPhonePredicate) {
        return inventory.stream().filter(smartPhonePredicate).collect(Collectors.toList());
    }
}
