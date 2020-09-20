package br.com.itjobhunters.vagas;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Builder
@Value
public class VagaPresencial extends Vaga {

    @Override
    public boolean isPresencial() {
        return true;
    }

    @Override
    public boolean isRemota() {
        return false;
    }
}
