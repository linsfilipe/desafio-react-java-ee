package com.github.linsfilipe.config;

import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import com.github.linsfilipe.domains.models.Pessoa;
import com.github.linsfilipe.domains.models.Profile;
import com.github.linsfilipe.domains.models.User;
import com.github.linsfilipe.domains.models.enums.EnumTipoPessoa;
import com.github.linsfilipe.services.IPessoaService;
import com.github.linsfilipe.services.IProfileService;
import com.github.linsfilipe.services.IUserService;

@Startup
@Singleton
public class GeneratedData {

    @Inject
    private IProfileService profileService;

    @Inject
    private IUserService userService;

    @Inject
    private IPessoaService pessoaService;

    @PostConstruct
    public void initData() {
        profileService.save(new Profile("Administrador"));
        profileService.save(new Profile("Gerente"));
        profileService.save(new Profile("Operador"));

        User admin = new User();
        admin.setLogin("admin");
        admin.setNome("Filipe");
        admin.setPerfil(profileService.findById(1));
        admin.setSenha("123456");
        userService.save(admin);
        
        User gerente = new User();
        gerente.setLogin("gabriela");
        gerente.setNome("Gabriela");
        gerente.setPerfil(profileService.findById(2));
        gerente.setSenha("123456");
        userService.save(gerente);
        
        User operador = new User();
        operador.setLogin("lucas");
        operador.setNome("Lucas");
        operador.setPerfil(profileService.findById(3));
        operador.setSenha("123456");
        userService.save(operador);
        
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Filipe Lins");
        pessoa1.setDocumento("02323993526");
        pessoa1.setDataNascimento(LocalDate.now().minusYears(28));
        pessoa1.setNomePai("Pedro Pai");
        pessoa1.setNomeMae("Maria Mãe");
        pessoa1.setLoginOperador("Sistema");
        pessoa1.setTipoPessoa(EnumTipoPessoa.FISICA);
        pessoaService.save(pessoa1);
        
    }


}
