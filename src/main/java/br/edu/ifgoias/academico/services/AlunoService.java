package br.edu.ifgoias.academico.services;

import java.util.List;

import br.edu.ifgoias.academico.entities.Aluno;
import br.edu.ifgoias.academico.repositories.AlunoRepository;

public class AlunoService {

    private AlunoRepository alunoRep;

    public List<AlunoService> findAll() {
        return alunoRep.findAll();
    }

    public Aluno findById(Integer id) {
        return ((AlunoRepository) alunoRep.findById(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Aluno insert(Aluno aluno) {
        return alunoRep.save(aluno);
    }

    public void delete(Integer id) {
        alunoRep.deleteById(id);
    }

    public Aluno update(Integer id, Aluno aluno) {
        return ((AlunoRepository) alunoRep.findById(id)).map(alunoDB -> {
            alunoDB.setNome(aluno.getNome());
            return alunoRep.save(alunoDB);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}