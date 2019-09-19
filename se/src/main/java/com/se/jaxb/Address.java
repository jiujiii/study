package com.se.jaxb;

import com.se.jaxb.cdata.CDataAdapter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Setter
@Getter
@Accessors(chain=true)
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ROOT_ADDRESS")
class Address {

    @XmlElement(name = "COUNTRY")
//    @XmlJavaTypeAdapter(CDataAdapter.class)
    private String country;

    @XmlElement(name = "PROVINCE")
//    @XmlJavaTypeAdapter(CDataAdapter.class)
    private String province;

    @XmlElement(name = "CITY")
//    @XmlJavaTypeAdapter(CDataAdapter.class)
    private String city;

}
