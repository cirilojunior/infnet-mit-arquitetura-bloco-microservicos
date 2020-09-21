package br.com.itjobhunters.vaga;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Builder
@Value
public class VagaRemota extends Vaga {

    @Override
    public boolean isPresencial() {
        return false;
    }

    @Override
    public boolean isRemota() {
        return true;
    }
}
