package br.ufpb.dcx.lab.mapper;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
public class ModelMapperCustom {
    private static ModelMapper mapper = new ModelMapper();

    public static <O,D> D convertObject(O origin, Class<D> destination){
        return mapper.map(origin, destination);
    }

    public static <O,D> List<D> convertListObjects(List<O> listOrigins, Class<D> destination){
        List<D> listDestination = new ArrayList<>();
        for (O objOrigin : listOrigins){
            listDestination.add(mapper.map(objOrigin,destination));
        }
        return listDestination;
    }
}
