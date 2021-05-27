package com.prodavnicatehnike.deliverer.models;
import java.io.Serializable;
import java.util.Objects;

public class AssemblyId implements Serializable {
	private Integer assemblyId;

    private Integer partId;
    
    public AssemblyId(Integer assemblyId, Integer partId) {
        this.assemblyId = assemblyId;
        this.partId = partId;
    }
    public AssemblyId(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssemblyId that = (AssemblyId) o;
        return assemblyId.equals(that.assemblyId) && partId.equals(that.partId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assemblyId, partId);
    }
}
