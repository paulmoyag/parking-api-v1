package api.parking.adapter.in.mapper;

import api.parking.adapter.in.dto.AddXparcUserRequestDto;
import api.parking.application.interfaces.in.AbstractXparcUserMapper;
import api.parking.domain.xparc.dto.XparcUserRegistryDto;

import javax.inject.Singleton;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

@Singleton
public class XparcRequestToUserRegistryMapper extends AbstractXparcUserMapper {

    @Override
    public XparcUserRegistryDto mapAddUserRequestToRegistry(AddXparcUserRequestDto addXparcUserRequestDto){
        XparcUserRegistryDto xparcUserRegistryDto = new XparcUserRegistryDto();
        xparcUserRegistryDto.setCountryCode(addXparcUserRequestDto.getCountryCode());
        xparcUserRegistryDto.setNumberPlates(Collections.emptyList());
        xparcUserRegistryDto.setFirstName(addXparcUserRequestDto.getFirstName());
        xparcUserRegistryDto.setLastName(addXparcUserRequestDto.getLastName());
        xparcUserRegistryDto.setActive(true);
        xparcUserRegistryDto.setPostPaymentAllowed(false);
        xparcUserRegistryDto.setWalletPaymentAllowed(false);
        Date todayDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        xparcUserRegistryDto.setValidityFrom(dateFormat.format(todayDate));
        xparcUserRegistryDto.setValidityUntil(null);
        return xparcUserRegistryDto;
    }
}
